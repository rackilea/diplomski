void print_goals(int m,int n,int i,int j,string s)
{
    if(i == m && j == n)
    {
      cout<<s+char(48+i)+'-'+char(48+j)<<endl;
      return;
    }
    if(i<=m)
    print_goals(m,n,i+1,j,s+char(48+i)+'-'+char(48+j)+',');
    if(j<=n)
    print_goals(m,n,i,j+1,s+char(48+i)+'-'+char(48+j)+',');



}