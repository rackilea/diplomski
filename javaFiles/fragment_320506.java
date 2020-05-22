// lenght of the flank of the cone
float flank_len = Math.sqrt(radius*radius + height*height); 

// unit vector along the flank of the cone
float cone_x = radius / flank_len; 
float cone_y = -height / flank_len;

.....

// Cone Bottom Normal
vertices.add(-cone_y * cos);
vertices.add( cone_x );
vertices.add(-cone_y * sin);

.....

// Cone Top Normal
vertices.add(-cone_y * cos);
vertices.add( cone_x );
vertices.add(-cone_y * sin);