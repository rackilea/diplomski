if (ltr) {
        m.setLocation(x, cy);
   } else { // RtoL orientation
        // here's the error: location is adjusted relative to the target width
        // without taking the insets into account ... 
        m.setLocation(target.width - x - m.width, cy);
   }