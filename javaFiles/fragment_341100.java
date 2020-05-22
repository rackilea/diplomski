// Initialize with your desired config 
EmojiCompat.init(BundledEmojiCompatConfig(context))

// Check if EmojiCompat was successfully loaded
if (EmojiCompat.get().loadState == EmojiCompat.LOAD_STATE_SUCCEEDED) {
    EmojiCompat.get().hasEmojiGlyph(yourString)
}