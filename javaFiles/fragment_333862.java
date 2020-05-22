import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;



public class InefficientDateShit {
    public static void main(final String[] args) throws ParseException {
        new Temp();
    }
}



class Temp {
    static public final SimpleDateFormat    formatter       = new SimpleDateFormat("yyyy/MM/dd");

    private final Fixtures                  fixtures;
    private final HashSet<Date>             team_fix_date   = new HashSet<>();
    private final HashSet<Date>             betWeek         = new HashSet<>();
    private final List<Game>                gamesTwo        = new ArrayList<>();


    public Temp() throws ParseException {
        fixtures = new Fixtures();

        // former matchesByDate()
        for (final Game game : fixtures.allLeagues) {
            team_fix_date.add(game.getDate());
        }

        // former dayTwo()
        final Date date = new Date();
        final Date today = new Date(date.getDay() - 1);
        Date date_5;
        final Calendar cal2 = Calendar.getInstance();
        cal2.clear(Calendar.HOUR_OF_DAY);
        cal2.clear(Calendar.AM_PM);
        cal2.clear(Calendar.MINUTE);
        cal2.clear(Calendar.SECOND);
        cal2.clear(Calendar.MILLISECOND);
        cal2.setTime(date);
        cal2.add(Calendar.DATE, 5);
        date_5 = cal2.getTime();
        for (final Date date_matches : team_fix_date) {
            if (date_matches.after(today) && date_matches.before(date_5)) {
                betWeek.add(date_matches);
            }
        }
    }

    public void addMatchesByDateTwo() {
        for (final Game game : fixtures.allLeagues) {
            final boolean matches = betWeek.contains(game.getDate()); // formerly done by weekMatches()
            if (matches) gamesTwo.add(game);
        }
    }
}



class Game {
    private final String    mLeague;
    private final String    mTeam1;
    private final String    mTeam2;
    private final Date      mDate;

    public Game(final String pLeague, final String pTeam1, final String pTeam2, final Date pDate) {
        mLeague = pLeague;
        mTeam1 = pTeam1;
        mTeam2 = pTeam2;
        mDate = pDate;
    }

    public String getLeague() {
        return mLeague;
    }
    public String getTeam1() {
        return mTeam1;
    }
    public String getTeam2() {
        return mTeam2;
    }
    public Date getDate() {
        return mDate;
    }
}



class Fixtures {
    public List<Game> allLeagues = new ArrayList<>();

    public Fixtures() throws ParseException {
        initFixtureBPL();
    }

    private void initFixtureBPL() throws ParseException {
        addGame("BRASILEIRAO SERIE A", "Flamengo", "Atletico-PR", "2016/08/06");
        addGame("BRASILEIRAO SERIE A", "America-MG", "Santos", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Figueirense", "Sport Recife", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Coritiba", "Ponte Preta", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Palmeiras", "Vitoria", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Internacional", " Fluminense", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Santa Cruz", "Sao Paulo", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Botafogo", "Gremio", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Atletico-MG", "Chapecoense-SC", "2016/08/07");
        addGame("BRASILEIRAO SERIE A", "Corinthians", "Cruzeiro", "2016/08/07");

        addGame("BRASILEIRAO SERIE A", "Vitoria", "Santa Cruz", "2016/08/13");
        addGame("BRASILEIRAO SERIE A", "Ponte Preta", "Figueirense", "2016/08/13");
        addGame("BRASILEIRAO SERIE A", "Sport Recife", "Flamengo", "2016/08/13");
        addGame("BRASILEIRAO SERIE A", "Fluminense", "America-MG", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Gremio", "Corinthians", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Cruzeiro", " Coritiba", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Santos", "Atletico-MG", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Sao Paulo", "Botafogo", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Atletico-PR", "Palmeiras", "2016/08/14");
        addGame("BRASILEIRAO SERIE A", "Chapecoense-SC", "Internacional", "2016/08/15");

        addGame("BRASILEIRAO SERIE A", "Corinthians", "Vitoria", "2016/08/20");
        addGame("BRASILEIRAO SERIE A", "America-MG", "Chapecoense-SC", "2016/08/19");
        addGame("BRASILEIRAO SERIE A", "Botafogo", "Sport Recife", "2016/08/20");
        addGame("BRASILEIRAO SERIE A", "Atletico-MG", "Atletico-PR", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Flamengo", "Gremio", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Internacional", "Sao Paulo", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Palmeiras", "Ponte Preta", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Santa Cruz", "Fluminense", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Figueirense", "Cruzeiro", "2016/08/21");
        addGame("BRASILEIRAO SERIE A", "Coritiba", "Santos", "2016/08/22");

        addGame("PRIMERA DIVISION CHILE", "Cobresal", "S. Wanderers", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "O'Higgins ", "U. Catolica", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "Palestino", "Huachipato", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "U. De Chile", "Antofagasta", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "Palestino", "Huachipato", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "U. Espanola", "U. De Concepcion", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "Deportes Temuco", "Deportes Iquique", "2016/08/08");
        addGame("PRIMERA DIVISION CHILE", "A. Italiano", "Colo Colo", "2016/08/08");

        addGame("PRIMERA DIVISION CHILE", "Antofagasta", "Cobresal", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "Colo Colo", "Deportes Temuco", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "Deportes Iquique", "O'Higgins", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "Huachipato", "U. Espanola", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "S. Wanderers", "A. Italiano", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "San Luis", "U. De Chile", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "U. Catolica", "Palestino", "2016/08/14");
        addGame("PRIMERA DIVISION CHILE", "U. De Concepcion", "Everton", "2016/08/14");

        addGame("PRIMERA DIVISION CHILE", "A. Italiano", "Antofagasta", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "Cobresal", "Deportes Iquique", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "Everton", "U. Espanola", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "Huachipato", "Colo Colo", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "O'Higgins", "Deportes Temuco", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "Palestino", "San luis", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "U. Catolica", "S. Wanderers", "2016/08/21");
        addGame("PRIMERA DIVISION CHILE", "U. De Chile", "U. De Concepcion", "2016/08/21");

        addGame("ECUADOR SERIE A", "U. Catolica", "Emelec", "2016/08/08");
        addGame("ECUADOR SERIE A", "Barcelona SC", "Mushuc Runa", "2016/08/08");
        addGame("ECUADOR SERIE A", "Dep. Cuenca", " Aucas", "2016/08/08");
        addGame("ECUADOR SERIE A", "Delfin", "River Ecuador", "2016/08/08");
        addGame("ECUADOR SERIE A", "Ind. del Valle", "Fuerza A.", "2016/08/08");
        addGame("ECUADOR SERIE A", "LDU Quito", "El Nacional", "2016/08/08");

        addGame("ECUADOR SERIE A", "Mushuc Runa", "Dep. Cuenca", "2016/08/13");
        addGame("ECUADOR SERIE A", "River Ecuador", "LDU Quito", "2016/08/14");
        addGame("ECUADOR SERIE A", "El Nacional", "Aucas", "2016/08/14");
        addGame("ECUADOR SERIE A", "Ind. del Valle", "U. Catolica", "2016/08/14");
        addGame("ECUADOR SERIE A", "Emelec", "Barcelona SC", "2016/08/14");
        addGame("ECUADOR SERIE A", "Fuerza A.", " Delfin", "2016/08/14");

        addGame("ECUADOR SERIE A", "Aucas", "Mushuc Runa", "2016/08/21");
        addGame("ECUADOR SERIE A", "Barcelona SC", "Fuerza A.", "2016/08/21");
        addGame("ECUADOR SERIE A", "Delfin", "Ind. del Valle", "2016/08/21");
        addGame("ECUADOR SERIE A", "Dep. Cuenca", "River Ecuador", "2016/08/21");
        addGame("ECUADOR SERIE A", "LDU Quito", "Emelec", "2016/08/21");
        addGame("ECUADOR SERIE A", "U. Católica", "El Nacional", "2016/08/21");

        addGame("PRIMERA DIVISION VENEZUELA", "Atl. Venezuela", "Aragua", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Dep. Anzoategui", "Estudiantes Caracas", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "JBL Zulia", "Lara", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Portuguesa", "Estudiantes M.", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Dep. Petare", "Mineros", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Monagas", "Llaneros", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Trujillanos", "La Guaira", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Urenna", "Caracas", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Carabobo", "Dep. Tachira", "2016/08/08");
        addGame("PRIMERA DIVISION VENEZUELA", "Zamora", "Zulia", "2016/08/08");

        addGame("PRIMERA DIVISION VENEZUELA", "La Guaira", "Atl. Venezuela", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Aragua", "Urena", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Llaneros", "Dep. Petare", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Zulia", "Trujillanos", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Estudiantes Caracas", "JBL Zulia", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Dep. Tachira", "Dep. Anzoategui", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Caracas", "Monagas", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Lara", "Estudiantes M.", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Mineros", "Carabobo", "2016/08/14");
        addGame("PRIMERA DIVISION VENEZUELA", "Zamora", "Portuguesa", "2016/08/14");

        addGame("PRIMERA DIVISION VENEZUELA", "JBL Zulia", "Dep. Tachira", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Portuguesa", "Lara", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Atl. Venezuela", "Zulia", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Monagas", "Aragua", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Trujillanos", "Zamora", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Carabobo", " Llaneros", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Dep. Anzoategui", "Mineros", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Dep. Petare", "Caracas", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Estudiantes de meridas", "Estudiantes Caracas", "2016/08/21");
        addGame("PRIMERA DIVISION VENEZUELA", "Ureña", "La Guaira", "2016/08/21");

        addGame("LIGA MX", "Veracruz", "America", "2016/08/08");
        addGame("LIGA MX", "Cruz Azul", "Tijuana", "2016/08/08");
        addGame("LIGA MX", "Morelia", "Atlas", "2016/08/08");
        addGame("LIGA MX", "UANL.", "Chiapas", "2016/08/08");
        addGame("LIGA MX", "Leon", "Monterrey", "2016/08/08");
        addGame("LIGA MX", "Guadalajara", "Queretaro", "2016/08/08");
        addGame("LIGA MX", "Necaxa", "UNAM.", "2016/08/08");
        addGame("LIGA MX", "Toluca", "Pachuca", "2016/08/08");
        addGame("LIGA MX", "Puebla", "Santos Laguna", "2016/08/08");

        addGame("LIGA MX", "Tijuana", "Leon", "2016/08/14");
        addGame("LIGA MX", "Queretaro ", "Cruz Azul", "2016/08/14");
        addGame("LIGA MX", "Atlas   ", "Puebla", "2016/08/14");
        addGame("LIGA MX", "Monterrey", "Necaxa", "2016/08/14");
        addGame("LIGA MX", "Pachuca", "UNAM", "2016/08/14");
        addGame("LIGA MX", "America", " Morelia", "2016/08/14");
        addGame("LIGA MX", "Toluca", "UANL", "2016/08/14");
        addGame("LIGA MX", "Chiapas", "Veracruz", "2016/08/14");
        addGame("LIGA MX", "Santos Laguna", "Guadalajara", "2016/08/14");

        addGame("LIGA MX", "Veracruz", "Toluca", "2016/07/21");
        addGame("LIGA MX", "Chiapas", "Morelia", "2016/07/21");
        addGame("LIGA MX", "Cruz Azul", "santos laguna.", "2016/07/21");
        addGame("LIGA MX", "Guadalajara", "Atlas", "2016/07/21");
        addGame("LIGA MX", "UANL", "Pachuca", "2016/07/21");
        addGame("LIGA MX", "Leon", "Queretaro", "2016/08/21");
        addGame("LIGA MX", "Necaxa", "Tijuana", "2016/08/21");
        addGame("LIGA MX", "UNAM", "Monterrey", "2016/08/21");
        addGame("LIGA MX", "Puebla", "America", "2016/08/21");

        addGame("MLS", "DC United", "Philadelphia Union", "2016/08/07");
        addGame("MLS", "Montreal Impact", "Houston Dynamo", "2016/08/07");
        addGame("MLS", "Toronto FC", "New England Revolution", "2016/08/07");
        addGame("MLS", "Colorado Rapids", "Vancouver Whitecaps", "2016/08/08");
        addGame("MLS", "Real Salt Lake", "Chicago Fire", "2016/08/08");
        addGame("MLS", "Portland Timbers", "Sporting Kansas City", "2016/08/08");
        addGame("MLS", "Orlando City", "Seattle Sounders", "2016/08/08");
        addGame("MLS", "Los Angeles Galaxy", "New York Red Bulls", "2016/08/08");

        addGame("MLS", "DC United", "Portland Timbers", "2016/08/13");
        addGame("MLS", "New York Red Bulls", "Montreal Impact", "2016/08/13");
        addGame("MLS", "Columbus Crew", "New York City", "2016/08/13");
        addGame("MLS", "New England Revolution", "Philadelphia Union", "2016/08/13");
        addGame("MLS", "FC Dallas", " Sporting Kansas City", "2016/08/13");
        addGame("MLS", "Houston Dynamo", "Toronto FC", "2016/08/13");
        addGame("MLS", "Los Angeles Galaxy", "Colorado Rapids", "2016/08/13");
        addGame("MLS", "Chicago Fire", "Orlando City", "2016/08/14");
        addGame("MLS", "Seattle Sounders", "Real Salt Lake", "2016/08/14");

        addGame("MLS", "New York City", "Los Angeles Galaxy", "2016/08/20");
        addGame("MLS", "Philadelphia Union", "Toronto FC    ", "2016/08/20");
        addGame("MLS", "Montreal Impact", "Chicago Fire", "2016/08/20");
        addGame("MLS", "New England Revolution", "Columbus Crew", "2016/08/20");
        addGame("MLS", "Colorado Rapids", "Orlando City ", "2016/08/20");
        addGame("MLS", "Real Salt Lake", "FC Dallas", "2016/08/20");
        addGame("MLS", "Sporting Kansas City", "Vancouver Whitecaps", "2016/08/20");
        addGame("MLS", "DC United", "New York Red Bulls", "2016/08/21");
        addGame("MLS", "Seattle Sounders", "Portland Timbers", "2016/08/21");

        addGame("J-LEAGUE", "Kashima", "Vegalta Sendai", "2016/08/08");
        addGame("J-LEAGUE", "Urawa", "Shonan", "2016/08/08");
        addGame("J-LEAGUE", "Albirex Niigata", "Kobe", "2016/08/08");
        addGame("J-LEAGUE", "G-Osaka", "Tosu", "2016/08/08");
        addGame("J-LEAGUE", "Hiroshima", "Nagoya", "2016/08/08");
        addGame("J-LEAGUE", "Kashiwa", "Yokohama M.", "2016/08/08");
        addGame("J-LEAGUE", "Kawasaki", "Kofu", "2016/08/08");
        addGame("J-LEAGUE", "Omiya Ardija", "Avispa Fukuoka", "2016/08/08");
        addGame("J-LEAGUE", "Tokyo", "Iwata", "2016/08/08");

        addGame("J-LEAGUE", "Kofu", "Albirex Niigata", "2016/08/13");
        addGame("J-LEAGUE", "Nagoya", "Urawa", "2016/08/13");
        addGame("J-LEAGUE", "Shonan", "Hiroshima", "2016/08/13");
        addGame("J-LEAGUE", "Iwata", "G-Osaka", "2016/08/13");
        addGame("J-LEAGUE", "Kobe   ", "Tokyo", "2016/08/13");
        addGame("J-LEAGUE", "Tosu", "Kawasaki ", "2016/08/13");
        addGame("J-LEAGUE", "Vegalta Sendai", "Kashiwa", "2016/08/13");
        addGame("J-LEAGUE", "Yokohama M.", "Omiya Ardija", "2016/08/13");
        addGame("J-LEAGUE", "Avispa Fukuoka", "Kashima", "2016/08/14");

        addGame("J-LEAGUE", "Kashima", "Shonan", "2016/08/20");
        addGame("J-LEAGUE", "Omiya Ardija", "Vegalta Sendai", "2016/08/20");
        addGame("J-LEAGUE", "Albirex Niigata", "Avispa Fukuoka", "2016/08/20");
        addGame("J-LEAGUE", "G-Osaka", "kobe", "2016/08/20");
        addGame("J-LEAGUE", "Hiroshima  ", "Kofu", "2016/08/20");
        addGame("J-LEAGUE", "Iwata", "Tosu", "2016/08/20");
        addGame("J-LEAGUE", "Kashiwa", "Nagoya", "2016/08/20");
        addGame("J-LEAGUE", "Tokyo", "Yokohama M.", "2016/08/20");
        addGame("J-LEAGUE", "Urawa", "Kawasaki", "2016/08/20");

        addGame("SUPERLIGA CHINA", "Beijing Guoan", "Chongqing Lifan", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Yanbian", "Shanghai SIPG", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Hangzhou Greentown", "Henan Construction", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Shanghai Shenhua", "Guangzhou", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Shijiazhuang", "Tianjin Teda", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Changchun Yatai", "Jiangsu Suning", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Guangzhou R&F", "Shandong Luneng", "2016/08/08");
        addGame("SUPERLIGA CHINA", "Hebei", "Liaoning", "2016/08/08");

        addGame("SUPERLIGA CHINA", "Guangzhou", "Hangzhou Greentown", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Shanghai SIPG ", "Shijiazhuang", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Shanghai Shenhua", "Liaoning", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Tianjin Teda", "Shandong Luneng", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Changchun Yatai", "Yanbian", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Chongqing Lifan", "Guangzhou R&F", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Henan Construction", "Hebei", "2016/08/14");
        addGame("SUPERLIGA CHINA", "Jiangsu Suning", "Beijing Guoan", "2016/08/14");

        addGame("SUPERLIGA CHINA", "Chongqing Lifan", "Yanbian", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Liaoning", "Hangzhou Greentown", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Hebei", "Guangzhou", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Shandong Luneng", "Changchun Yatai", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Shanghai SIPG", "Beijing Guoan", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Tianjin Teda", " Henan Construction", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Guangzhou R&F", "Shangai Shenhua", "2016/08/21");
        addGame("SUPERLIGA CHINA", "Shijiazhuang", "Jiangsu Suning", "2016/08/21");

        addGame("DINAMARCA SUPERLIGA", "Odense", "Viborg", "2016/08/08");
        addGame("DINAMARCA SUPERLIGA", "Nordsjaelland", "Aalborg", "2016/08/08");
        addGame("DINAMARCA SUPERLIGA", "Sonderjyske", "FC Copenhague", "2016/08/08");
        addGame("DINAMARCA SUPERLIGA", "Midtjylland", "Brondby", "2016/08/08");
        addGame("DINAMARCA SUPERLIGA", "Esbjerg", "Aarhus", "2016/08/08");

        addGame("DINAMARCA SUPERLIGA", "Viborg", "Randers", "2016/08/12");
        addGame("DINAMARCA SUPERLIGA", "Lyngby", "Aarhus", "2016/08/13");
        addGame("DINAMARCA SUPERLIGA", "Horsens", "Silkeborg", "2016/08/13");
        addGame("DINAMARCA SUPERLIGA", "FC Copenhague", "Midtjylland", "2016/08/13");
        addGame("DINAMARCA SUPERLIGA", "Odense", "Nordsjaelland", "2016/08/14");
        addGame("DINAMARCA SUPERLIGA", "Brondby", "Sonderjyske", "2016/08/14");
        addGame("DINAMARCA SUPERLIGA", "Aalborg", "Esbjerg", "2016/08/15");

        addGame("DINAMARCA SUPERLIGA", "Nordsjaelland", "Randers", "2016/08/19");
        addGame("DINAMARCA SUPERLIGA", "Horsens", "Lyngby", "2016/08/19");
        addGame("DINAMARCA SUPERLIGA", "FC Copenhague", "Aalborg", "2016/08/20");
        addGame("DINAMARCA SUPERLIGA", "Silkeborg", "Viborg", "2016/08/21");
        addGame("DINAMARCA SUPERLIGA", "Aarhus", "Brondby", "2016/08/21");
        addGame("DINAMARCA SUPERLIGA", "Midtjylland", "Sonderjyske", "2016/08/21");
        addGame("DINAMARCA SUPERLIGA", "Esbjerg", "Odense", "2016/08/22");

        addGame("EREDIVISIE", "Nijmegen", "Zwolle", "2016/08/08");
        addGame("EREDIVISIE", " Den Haag", "G.A. Eagles", "2016/08/08");
        addGame("EREDIVISIE", "Twente", "Excelsior", "2016/08/08");
        addGame("EREDIVISIE", "Utrecht", "PSV", "2016/08/08");
        addGame("EREDIVISIE", "Willem", "Vitesse", "2016/08/08");
        addGame("EREDIVISIE", "Groningen", "Feyenoord", "2016/08/08");
        addGame("EREDIVISIE", "AZ Alkmaar", "Heerenveen", "2016/08/08");
        addGame("EREDIVISIE", "Sparta Rotterdam", "Ajax", "2016/08/08");
        addGame("EREDIVISIE", "Roda", "Heracles", "2016/08/08");

        addGame("EREDIVISIE", "Heerenveen", "Utrecht", "2016/08/12");
        addGame("EREDIVISIE", " Excelsior", "Groningen", "2016/08/13");
        addGame("EREDIVISIE", "Ajax", "Roda", "2016/08/13");
        addGame("EREDIVISIE", "Vitesse", "Den Haag", "2016/08/13");
        addGame("EREDIVISIE", "Zwolle", "Sparta Rotterdam", "2016/08/13");
        addGame("EREDIVISIE", "Heracles", "Willem II", "2016/08/14");
        addGame("EREDIVISIE", "Feyenoord", "Twente", "2016/08/14");
        addGame("EREDIVISIE", "G.A. Eagles", "Nijmegen", "2016/08/14");
        addGame("EREDIVISIE", "PSV", "AZ Alkmaar", "2016/08/14");

        addGame("EREDIVISIE", "Excelsior", "Den Haag", "2016/08/19");
        addGame("EREDIVISIE", " Roda", "Vitesse", "2016/08/20");
        addGame("EREDIVISIE", "Ajax", "Willem II", "2016/08/20");
        addGame("EREDIVISIE", "Zwolle", "PSV", "2016/08/20");
        addGame("EREDIVISIE", "Nijmegen", "Heerenveen", "2016/08/20");
        addGame("EREDIVISIE", "Groningen", "Twente", "2016/08/21");
        addGame("EREDIVISIE", "Sparta Rotterdam", "G.A. Eagles", "2016/08/21");
        addGame("EREDIVISIE", "Utrecht", "AZ Alkmaar", "2016/08/21");
        addGame("EREDIVISIE", "Heracles", "Feyenoord", "2016/08/21");
    }


    private void addGame(final String pLeague, final String pTeam1, final String pTeam2, final String pDate) throws ParseException {
        final Date date = Temp.formatter.parse(pDate);
        allLeagues.add(new Game(pLeague, pTeam1, pTeam2, date));
    }

}