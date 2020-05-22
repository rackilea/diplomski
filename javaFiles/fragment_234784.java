@Override
        public void mouseClicked(MouseEvent me) {
            super.mouseClicked(me);

            for (int i = 0; i < polygons.length; i++) {
                if (polygons[i].contains(me.getPoint())) {
                    System.out.println("Clicked polygon " + i);
                    break;
                }
            }

        }