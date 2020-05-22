Mat m; 


byte[] bytes = new byte[ m.rows() * m.cols() * m.channels() ];

m.get(0,0, bytes);