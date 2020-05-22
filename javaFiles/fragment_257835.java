int count = canvas.save();
    canvas.translate(r.left, r.top);
    int width = this.width < 0 ? r.width() : this.width;
    int height = this.height < 0 ? r.height() : this.height;
    int fontSize = this.fontSize < 0 ? (Math.min(width, height) / 2) : this.fontSize;
    textPaint.setTextSize(fontSize);
    String[] lines = text.split("\n");
    int yoff = 0;
    for (int i = 0; i < lines.length; ++i) {
        canvas.drawText(lines[i], width / 2, (height / 2 - ((textPaint.descent() + textPaint.ascent()) / 2)) + yoff, textPaint);
        textPaint.getTextBounds(lines[i], 0, lines[i].length(), r);
        yoff += r.height();
    }
    canvas.restoreToCount(count);