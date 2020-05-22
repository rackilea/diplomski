package work.basil.example;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CsvSpeed
{
    public List < Person > read ( Path path )
    {
        // TODO: Add a check for valid file existing.

        List < Person > list = List.of();  // Default to empty list.
        try
        {
            // Prepare list.
            int initialCapacity = ( int ) Files.lines( path ).count();
            list = new ArrayList <>( initialCapacity );

            // Read CSV file. For each row, instantiate and collect `DailyProduct`.
            BufferedReader reader = Files.newBufferedReader( path );
            Iterable < CSVRecord > records = CSVFormat.RFC4180.withFirstRecordAsHeader().parse( reader );
            for ( CSVRecord record : records )
            {
                String givenName = record.get( "givenName" );
                String surname = record.get( "surname" );
                UUID id = UUID.fromString( record.get( "id" ) );
                String description = record.get( "description" );
                // Instantiate `Person` object, and collect it.
                Person person = new Person( givenName , surname , id , description );
                list.add( person );
            }
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
        return list;
    }

    public void write ( final Path path )
    {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        try ( final CSVPrinter printer = CSVFormat.RFC4180.withHeader( "givenName" , "surname" , "id" , "description" ).print( path , StandardCharsets.UTF_8 ) ; )
        {
            int limit = 40_000;  // 40_000 yields about 20 MB of data.
            List < String > givenNames = List.of( "Adrien" , "Aimon" , "Alerion" , "Alexis" , "Alezan" , "Ancil" , "Andre" , "Antoine" , "Archard" , "Aurélien" , "Averill" , "Baptiste" , "Barnard" , "Bartelemy" , "Bastien" , "Baylee" , "Beale" , "Beau" , "Beaumont" , "Beauregard" , "Bellamy" , "Berger" , "Blaize" , "Blondel" , "Boyce" , "Bruce" , "Brunelle" , "Brys" , "Burcet" , "Burnell" , "Burrell" , "Byron" , "Canaan" , "Carden" , "Carolas" , "Cavell" , "Chace" , "Chanler" , "Chante" , "Chappel" , "Charles" , "Chasen" , "Chason" , "Chemin" , "Chene" , "Cher" , "Chevalier" , "Cheyne" , "Clément" , "Clemence" , "Corbin" , "Coty" , "Cygne" , "Damien" , "Dandre" , "Dariel" , "Darl" , "Dauphine" , "Davet" , "Dax" , "Dean" , "Delice" , "Delmon" , "Destin" , "Dominique" , "Donatien" , "Duke" , "Eliott" , "Elroy" , "Enzo" , "Erwan" , "Etalon" , "Ethan" , "Fabron" , "Ferrand" , "Filberte" , "Florent" , "Florian" , "Fontaine" , "Forest" , "Fortune" , "Franchot" , "Francois" , "Fraser" , "Frayne" , "Gaëtan" , "Gabin" , "Gage" , "Gaige" , "Garland" , "Garner" , "Gaston" , "Gauge" , "Gaylord" , "Germain" , "Germaine" , "German" , "Gervaise" , "Giles" , "Gilles" , "Gitan" , "Grosvener" , "Guifford" , "Guion" , "Guy" , "Guzman" , "Henri" , "Holland" , "Hugo" , "Hugues" , "Hyacinthe" , "Jérémy" , "Jacquan" , "Jacques" , "Jacquez" , "Janvier" , "Jardan" , "Jay" , "Jaye" , "Jehan" , "Jemond" , "Jocquez" , "Jonathan" , "Jules" , "Julien" , "Justus" , "Karoly" , "Lado" , "Lafayette" , "Lamond" , "Lancelin" , "Landis" , "Landry" , "Laron" , "Larrimore" , "Laurent" , "LaValle" , "Leandre" , "Leggett" , "Leonce" , "Leron" , "Leverett" , "Lilian" , "Loïc" , "Lorenzo" , "Louis" , "Lowell" , "Luc" , "Lucien" , "Lukas" , "Macaire" , "Mace" , "Mahieu" , "Maison" , "Malleville" , "Manneville" , "Mantel" , "Marc" , "Marcel" , "Marion" , "Marius" , "Markez" , "Markis" , "Marmion" , "Marquis" , "Marquise" , "Marshall" , "Martial" , "Maslin" , "Mason" , "Matheo" , "Mathias" , "Mathys" , "Matthieu" , "Maxence" , "Mayson" , "Mehdi" , "Merle" , "Merville" , "Montague" , "Montaigu" , "Monte" , "Montgomery" , "Montreal" , "Montrel" , "Moore" , "Morel" , "Mortimer" , "Nerville" , "Neuveville" , "Nicolas" , "Noë" , "Noah" , "Noe" , "Norman" , "Norville" , "Nouel" , "Olivier" , "Onfroi" , "Paien" , "Parfait" , "Parnell" , "Pascal" , "Patrice" , "Paul" , "Peppin" , "Percival" , "Percy" , "Pernell" , "Peverell" , "Philipe" , "Pierpont" , "Pierre" , "Pomeroy" , "Prewitt" , "Purvis" , "Quennell" , "Quentin" , "Quincey" , "Quincy" , "Quintin" , "Rémi" , "Rafaelle" , "Ranger" , "Raoul" , "Raphaël" , "Rapier" , "Rawlins" , "Ray" , "Raynard" , "Remi" , "René" , "Renard" , "Rene" , "Reule" , "Reynard" , "Robin" , "Romain" , "Rondel" , "Roy" , "Royal" , "Ruff" , "Rush" , "Russel" , "Rustin" , "Sabastien" , "Sacha" , "Salomon" , "Samuel" , "Satordi" , "Saville" , "Scoville" , "Sebastien" , "Sennett" , "Severin" , "Shant" , "Shantae" , "Sidney" , "Siffre" , "Simeon" , "Simon" , "Sinclair" , "Sofiane" , "Somer" , "Stephane" , "Sully" , "Sydney" , "Sylvain" , "Talbot" , "Talon" , "Telford" , "Tempest" , "Teppo" , "Théo" , "Thayer" , "Thibault" , "Thibaut" , "Thiery" , "Tiennan" , "Tiennot" , "Titouan" , "Toussaint" , "Travaris" , "Tyson" , "Urson" , "Vachel" , "Valentin" , "Valere" , "Vallis" , "Verdun" , "Victoir" , "Victor" , "Waltier" , "William" , "Wyatt" , "Yanis" , "Yann" , "Yves" , "Yvon" , "Zosime" , "Abrial" , "Abrielle" , "Abril" , "Adele" , "Alair" , "Alerion" , "Amee" , "Angelique" , "Annette" , "Antonella" , "Arian" , "Ariane" , "Armandina" , "Aubree" , "Aubrielle" , "Audra" , "Avril" , "Bella" , "Berneta" , "Bette" , "Blaise" , "Blanche" , "Blasa" , "Bonte" , "Brie" , "Brienne" , "Brigit" , "Cachay" , "Calice" , "Camille" , "Camylle" , "Caprice" , "Caressa" , "Caroline" , "Catin" , "Celesta" , "Celeste" , "Cera" , "Cerise" , "Chablis" , "Chalice" , "Chambray" , "Champagne" , "Chandell" , "Chaney" , "Chantal" , "Chante" , "Chanterelle" , "Chantile" , "Chantilly" , "Chantrice" , "Charla" , "Charlotte" , "Charmane" , "Chaton" , "Chemin" , "Chenetta" , "Cher" , "Chere" , "Cheri" , "Cheryl" , "Christine" , "Cidney" , "Cinderella" , "Claire" , "Claudette" , "Colette" , "Cordelle" , "Cydnee" , "Daeja" , "Daija" , "Daja" , "Damzel" , "Darelle" , "Darlene" , "Darselle" , "Dejanelle" , "Deleena" , "Delice" , "Demeri" , "Deni" , "Denise" , "Desgracias" , "Desire" , "Desiree" , "Destanee" , "Destiny" , "Dior" , "Domanique" , "Dominique" , "Elaina" , "Elaine" , "Elayna" , "Elise" , "Eloisa" , "Elyse" , "Emeline" , "Emmaline" , "Emmeline" , "Estella" , "Estrella" , "Etiennette" , "Evette" , "Fabienne" , "Fabrienne" , "Fanchon" , "Fancy" , "Fawna" , "Fayana" , "Fayette" , "Fifi" , "Fleur" , "Fleurette" , "Fontanna" , "Fosette" , "Francine" , "Frederique" , "Gabriel" , "Gabriele" , "Gabrielle" , "Gaby" , "Garcelle" , "Gena" , "Genie" , "Georgette" , "Germaine" , "Gervaise" , "Gitana" , "Harriet" , "Heloisa" , "Holland" , "Honnetta" , "Isabelle" , "Ivette" , "Ivonne" , "Jacqueena" , "Jacquetta" , "Jacquiline" , "Jacyline" , "Jaime" , "Jakqueline" , "Janeen" , "Janelly" , "Janina" , "Janiqua" , "Janique" , "Jannnelle" , "Jaquita" , "Jardena" , "Jeanetta" , "Jermaine" , "Jessamine" , "Jewel" , "Jewell" , "Joli" , "Jolie" , "Josephine" , "Jozephine" , "Julieta" , "Karessa" , "Karmaine" , "Klara" , "Laine" , "Lanelle" , "Laramie" , "Layne" , "Layney" , "Leala" , "Leonette" , "Lissette" , "Lizette" , "Lourdes" , "Lucienne" , "Ly" , "Lyla" , "Lysette" , "Madelaine" , "Malerie" , "Manette" , "Marais" , "Marcelle" , "Marché" , "Mardi" , "Margo" , "Marguerite" , "Marie" , "Marie Claude" , "Marie Frances" , "Marie Joelle" , "Marie Pascale" , "Marie Sophie" , "Marjolaine" , "Marquise" , "Marvella" , "Mathieu" , "Matisse" , "Maurelle" , "Maurissa" , "Mavis" , "Melisande" , "Michelle" , "Miette" , "Mignon" , "Mimi" , "Mirya" , "Monet" , "Moniqua" , "Monteen" , "Musetta" , "Myrlie" , "Nadeen" , "Nadia" , "Nadiyah" , "Naeva" , "Nanon" , "Natalle" , "Naudia" , "Nettie" , "Nicholas" , "Nicki" , "Nicky" , "Nicole" , "Nicolette" , "Nicolina" , "Nicolle" , "Nikolette" , "Ninette" , "Ninon" , "Noelle" , "Nycole" , "Odelette" , "Opaline" , "Orane" , "Orva" , "Page" , "Parisa" , "Parnel" , "Parris" , "Patrice" , "Peridot" , "Pippi" , "Prairie" , "Rachele" , "Rachelle" , "Racquel" , "Raphaelle" , "Raquelle" , "Remi" , "Renée" , "Renea" , "Renelle" , "Renita" , "Risette" , "Rochelle" , "Romy" , "Rosabel" , "Rosiclara" , "Ruba" , "Russhell" , "Saleena" , "Salina" , "Satin" , "Sedona" , "Serene" , "Shandelle" , "Shanta" , "Shante" , "Shariah" , "Sharita" , "Sharleen" , "Sheree" , "Shereen" , "Sherell" , "Sherice" , "Sherry" , "Sidnee" , "Sidney" , "Sidnie" , "Sidonie" , "Sinclaire" , "Solange" , "Solen" , "Sorrel" , "Suzette" , "Sydnee" , "Sydney" , "Tallis" , "Tempest" , "Toinette" , "Turquoise" , "Veronique" , "Vignette" , "Villette" , "Violeta" , "Virginie" , "Voleta" , "Vonny" );
            List < String > surnames = List.of( "Arceneau" , "Aucoin" , "Babin" , "Babineaux" , "Benoit" , "Bergeron" , "Bernard" , "Bertrand" , "Bessette" , "Blanc" , "Blanchard" , "Bonnet" , "Boucher" , "Bourg" , "Bourque" , "Boutin" , "Bouvier" , "Braud" , "Broussard" , "Brun" , "Chevalier" , "David" , "Depaul" , "Desmarais" , "Disney" , "Dubois" , "Dupont" , "Dupuis" , "Durand" , "Fortescue" , "Fournier" , "Garnier" , "Gaudet" , "Gillet" , "Gillette" , "Girard" , "Gravois" , "Grosvenor" , "Lambert" , "Landry" , "Laroche" , "Laurent" , "Lefevre" , "Leroy" , "Leveque" , "Lisle" , "Martin" , "Michel" , "Molyneux" , "Moreau" , "Morel" , "Neville" , "Pelletier" , "Petit" , "Prideux" , "Renard" , "Richard" , "Robert" , "Rousseau" , "Roux" , "Rufus" , "Simon" , "Thomas" );
            for ( int i = 1 ; i <= limit ; i++ )
            {
                String givenName = givenNames.get( random.nextInt( 0 , givenNames.size() ) );
                String surname = surnames.get( random.nextInt( 0 , surnames.size() ) );
                UUID id = UUID.randomUUID();
                String description = Person.LOREM_IPSUM;
                printer.printRecord( givenName , surname , id , description );
            }
        } catch ( IOException e )
        {
            e.printStackTrace();
        }
    }

    public static void main ( final String[] args )
    {
        // Launch the app.
        CsvSpeed app = new CsvSpeed();

        // Write.
        String when = Instant.now().truncatedTo( ChronoUnit.SECONDS ).toString().replace( ":" , "•" );
        Path pathOutput = Paths.get( "/Users/basilbourque/persons.csv" );
        app.write( pathOutput );
        System.out.println( "Writing file: " + pathOutput );

        // Read.
        long start = System.nanoTime();
        Path pathInput = Paths.get( "/Users/basilbourque/persons.csv" );
        List < Person > list = app.read( pathInput );
        long stop = System.nanoTime();

        // Time.
        long elapsed = ( stop - start );
        Duration d = Duration.ofNanos( elapsed );
        System.out.println( "Reading elapsed: " + d );
        System.out.println( "Reading took nanos per row: " + ( elapsed / list.size() ) );
        System.out.println( "nanos elapsed: " + elapsed + "  |  list.size: " + list.size() );
    }
}