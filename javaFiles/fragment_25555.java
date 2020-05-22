addMouseMotionListener(new MouseAdapter() {
            public void mouseMoved(MouseEvent e) {
                /**
                 * Check location of mouse pointer if(specified_edge)move(scr_buffer)
                 *
                 */

                isRightBorder = false;
                isBottomBorder = false;
                isTopBorder = false;
                isLeftBorder = false;