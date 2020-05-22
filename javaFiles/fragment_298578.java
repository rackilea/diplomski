while (other >= 0 && (((first > second) ? 1 : 0) == asc)) {
     movies[other+1] = movies[other];
     other = other - 1;
     if (other >= 0) {
         second = (int) movies[other].getTitle().toLowerCase().charAt(0);
     }
 }