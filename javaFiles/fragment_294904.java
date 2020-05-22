super.paintComponent(g);

Graphics2D g2 = (Graphics2D)g.create();

AffineTransform tx = new AffineTransform(); //
tx.concatenate( g2.getTransform() );
tx.scale(...); 
g2.setTransform(tx);

// do custom painting

g2.dispose(); // release Graphics resources