Matrix a = new Basic2DMatrix(...); // simple 2D array matrix
Matrix b = new Basic2DMatrix(...); // that is too

Matrix c = a.multiply(b); // a * b in sequental mode

Matrix c = a.par().multiply(b); // a * b in parallel mode