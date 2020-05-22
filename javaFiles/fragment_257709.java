private void setText(CharSequence text, BufferType type,
                     boolean notifyBefore, int oldlen) {
    if (text == null) {
        text = "";
    }

    // If suggestions are not enabled, remove the suggestion spans from the text
    if (!isSuggestionsEnabled()) {
        text = removeSuggestionSpans(text);
    }

    if (!mUserSetTextScaleX) mTextPaint.setTextScaleX(1.0f);

    if (text instanceof Spanned &&
        ((Spanned) text).getSpanStart(TextUtils.TruncateAt.MARQUEE) >= 0) {
        if (ViewConfiguration.get(mContext).isFadingMarqueeEnabled()) {
            setHorizontalFadingEdgeEnabled(true);
            mMarqueeFadeMode = MARQUEE_FADE_NORMAL;
        } else {
            setHorizontalFadingEdgeEnabled(false);
            mMarqueeFadeMode = MARQUEE_FADE_SWITCH_SHOW_ELLIPSIS;
        }
        setEllipsize(TextUtils.TruncateAt.MARQUEE);
    }

    int n = mFilters.length;
    for (int i = 0; i < n; i++) {
        CharSequence out = mFilters[i].filter(text, 0, text.length(), EMPTY_SPANNED, 0, 0);
        if (out != null) {
            text = out;
        }
    }

    if (notifyBefore) {
        if (mText != null) {
            oldlen = mText.length();
            sendBeforeTextChanged(mText, 0, oldlen, text.length());
        } else {
            sendBeforeTextChanged("", 0, 0, text.length());
        }
    }

    boolean needEditableForNotification = false;

    if (mListeners != null && mListeners.size() != 0) {
        needEditableForNotification = true;
    }

    if (type == BufferType.EDITABLE || getKeyListener() != null ||
            needEditableForNotification) {
        createEditorIfNeeded();
        mEditor.forgetUndoRedo();
        Editable t = mEditableFactory.newEditable(text);
        text = t;
        setFilters(t, mFilters);
        InputMethodManager imm = InputMethodManager.peekInstance();
        if (imm != null) imm.restartInput(this);
    } else if (type == BufferType.SPANNABLE || mMovement != null) {
        text = mSpannableFactory.newSpannable(text);
    } else if (!(text instanceof CharWrapper)) {
        text = TextUtils.stringOrSpannedString(text);
    }

    if (mAutoLinkMask != 0) {
        Spannable s2;

        if (type == BufferType.EDITABLE || text instanceof Spannable) {
            s2 = (Spannable) text;
        } else {
            s2 = mSpannableFactory.newSpannable(text);
        }

        if (Linkify.addLinks(s2, mAutoLinkMask)) {
            text = s2;
            type = (type == BufferType.EDITABLE) ? BufferType.EDITABLE : BufferType.SPANNABLE;

            /*
             * We must go ahead and set the text before changing the
             * movement method, because setMovementMethod() may call
             * setText() again to try to upgrade the buffer type.
             */
            mText = text;

            // Do not change the movement method for text that support text selection as it
            // would prevent an arbitrary cursor displacement.
            if (mLinksClickable && !textCanBeSelected()) {
                setMovementMethod(LinkMovementMethod.getInstance());
            }
        }
    }

    mBufferType = type;
    mText = text;

    if (mTransformation == null) {
        mTransformed = text;
    } else {
        mTransformed = mTransformation.getTransformation(text, this);
    }

    final int textLength = text.length();

    if (text instanceof Spannable && !mAllowTransformationLengthChange) {
        Spannable sp = (Spannable) text;

        // Remove any ChangeWatchers that might have come from other TextViews.
        final ChangeWatcher[] watchers = sp.getSpans(0, sp.length(), ChangeWatcher.class);
        final int count = watchers.length;
        for (int i = 0; i < count; i++) {
            sp.removeSpan(watchers[i]);
        }

        if (mChangeWatcher == null) mChangeWatcher = new ChangeWatcher();

        sp.setSpan(mChangeWatcher, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE |
                   (CHANGE_WATCHER_PRIORITY << Spanned.SPAN_PRIORITY_SHIFT));

        if (mEditor != null) mEditor.addSpanWatchers(sp);

        if (mTransformation != null) {
            sp.setSpan(mTransformation, 0, textLength, Spanned.SPAN_INCLUSIVE_INCLUSIVE);
        }

        if (mMovement != null) {
            mMovement.initialize(this, (Spannable) text);

            /*
             * Initializing the movement method will have set the
             * selection, so reset mSelectionMoved to keep that from
             * interfering with the normal on-focus selection-setting.
             */
            if (mEditor != null) mEditor.mSelectionMoved = false;
        }
    }

    if (mLayout != null) {
        checkForRelayout();
    }

    sendOnTextChanged(text, 0, oldlen, textLength);
    onTextChanged(text, 0, oldlen, textLength);

    notifyViewAccessibilityStateChangedIfNeeded(AccessibilityEvent.CONTENT_CHANGE_TYPE_TEXT);

    if (needEditableForNotification) {
        sendAfterTextChanged((Editable) text);
    }

    // SelectionModifierCursorController depends on textCanBeSelected, which depends on text
    if (mEditor != null) mEditor.prepareCursorControllers();
}