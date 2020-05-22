StringBuilder sb=new StringBuilder();
for(int i=0; i<row; i++) 
{

    for(int j=0; j<col; j++) 
    {
        sb.append('\t');    
        sb.append(mat[i][j]);
    }
    sb.append('\n');
}
System.out.println(sb.toString());