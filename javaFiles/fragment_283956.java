face = new FilledOval( mousePoint, FACE_RADIUS, FACE_RADIUS, canvas);
leftEar = new FilledOval( (X_POS - (EAR_RADIUS / 2)),
                          (Y_POS - (EAR_RADIUS / 2)),
                          EAR_RADIUS, EAR_RADIUS, canvas );
rightEar = new FilledOval((X_POS + (EAR_OFFSET - (EAR_RADIUS / 2))) ,
                          (Y_POS - (EAR_RADIUS / 2)),
                          EAR_RADIUS, EAR_RADIUS, canvas );