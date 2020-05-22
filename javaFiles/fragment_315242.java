if (p != null) {
            if (p.y >= height) { // You'll need to define height...
                // Do something here
            } else {
                p.y++;
                m.drawParticle(p.x, p.y);
            }
        }