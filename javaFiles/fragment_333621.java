ts = now(); 
d = DDE("file.xlsx"); 
while (d.error) { 
    d = DDE("file.xlsx"); 
} 
load_time = now() - ts;