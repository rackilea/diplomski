void onDraw(Canvas canvas, boolean isBooked) {
            if (_a != null) {
                // Draw a shadow of the bubble
                float l = _left + mScrollLeft + 4;
                float t = _top + mScrollTop + 4;
                canvas.drawRoundRect(new RectF(l, t, l + _w, t + _h), 20.0f, 20.0f, bubbleShadowPaint);
                Path path = new Path();
                float ox = _x + mScrollLeft + 1;
                float oy = _y + mScrollTop + 1;
                int yoffset = -35;
                if (_top > _y) {
                    yoffset = 35;
                }
                // draw shadow of pointer to origin
                path.moveTo(ox, oy);
                path.lineTo(ox - 5, oy + yoffset);
                path.lineTo(ox + 5 + 4, oy + yoffset);
                path.lineTo(ox, oy);
                path.close();
                canvas.drawPath(path, bubbleShadowPaint);

                // draw the bubble
                l = _left + mScrollLeft;
                t = _top + mScrollTop;
            if (isBooked) {
                canvas.drawRoundRect(new RectF(l, t, l + _w, t + _h), 20.0f, 20.0f, bookedBubblePaint);
            } else {
                canvas.drawRoundRect(new RectF(l, t, l + _w, t + _h), 20.0f, 20.0f, bubblePaint);
            }

                path = new Path();
                ox = _x + mScrollLeft;
                oy = _y + mScrollTop;
                yoffset = -35;
                if (_top > _y) {
                    yoffset = 35;
                }
                // draw pointer to origin
                path.moveTo(ox, oy);
                path.lineTo(ox - 5, oy + yoffset);
                path.lineTo(ox + 5, oy + yoffset);
                path.lineTo(ox, oy);
                path.close();
            if (isBooked) {
                canvas.drawPath(path, bookedBubblePaint);
            } else {
                canvas.drawPath(path, bubblePaint);
            }


                // draw the message
                canvas.drawText(_text, l + (_w / 2), t + _baseline - 10, textPaint);
            }
        }