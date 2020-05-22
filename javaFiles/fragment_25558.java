if (x < 0) {
                        x = 0;
                } else if (x + getWidth() > map_buffer.getWidth()) {
                        x = map_buffer.getWidth() - getWidth();
                }
                if (y < 0) {
                        y = 0;
                } else if (y + getHeight() > map_buffer.getHeight()) {
                    y = map_buffer.getHeight() - getHeight();
                }