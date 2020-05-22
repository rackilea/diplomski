File[] fs=null;                                                                            
File f= ??? ; //you never initialize f in the for loop, you need a starting value  
int t, size;                                                                               

for (t=0,size=(fs=((f=f.getParentFile()).listFiles(filt))).size();      
     fs==null;                                                                             
     t++) {
       if(t>maxDepth) {throw new Exception("No dir to read");}
     }
}