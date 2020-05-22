protected boolean shouldRender() throws JspException {
    try {
        if (this.getPath() != null &&
                this.getPath() != "") {
            // Field errors
            return (this.bind.hasFieldErrors(this.getPath()));
        } else {
            // Global errors
            return this.bind.hasGlobalErrors();
        }
    } catch (IllegalStateException ex) {
        // Neither BindingResult nor target object available.
        return false;
    }
}

protected int writeTagContent(TagWriter tagWriter) throws JspException{
    if (shouldRender()) {
        return doWrite(tagWriter);
    }
    return BodyTag.SKIP_BODY;
}

protected int doWrite(TagWriter tagWriter) throws JspException {
    try {
        tagWriter.startTag(getElement());
        writeDefaultAttributes(tagWriter);
        String delimiter = ObjectUtils.getDisplayString(evaluate("delimiter", getDelimiter()));
        List<String> errorMessages = null;
        if (this.getPath() != null) {
            errorMessages = getFieldErrorMessages(bind.getFieldErrors(this.getPath()));
        } else {
            errorMessages = getGlobalErrorMessages(bind.getGlobalErrors());
        }
        tagWriter.appendValue("<ul>");
        for (int i = 0; i < errorMessages.size(); i++) {
            String errorMessage = errorMessages.get(i);
            tagWriter.appendValue("<li>");
            tagWriter.appendValue(getDisplayString(errorMessage));
            tagWriter.appendValue("</li>");
        }
        tagWriter.appendValue("</ul>");
        tagWriter.forceBlock();
        tagWriter.endTag();
    } catch (NullPointerException ex) {
        ex.printStackTrace();
    }

    return BodyTag.EVAL_BODY_INCLUDE;
}