Set<String> eurocountries= new HashSet<String>();
eurocountries.add("FRA");eurocountries.add("GER");eurocountries.add("ITA");

if (eurocountries.contains(usercountry))
{
    costpermile = costpermile*1.42; 
}