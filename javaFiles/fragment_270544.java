public class PlayerTest extends TestCase {

    Mockery context = new Mockery();    

    public void testTakeTurn() {
        final Board b = context.mock(Board.class);
        final Piece p = context.mock(Piece.class);
        final Die d = context.mock(Die.class);

        Player pl = new Player();
        final int roll1 = 2;
        final int roll2 = 3;

        context.checking(new Expectations() {{
            exactly(2).of (d).roll();
            will(onConsecutiveCalls(
              returnValue(roll1),
              returnValue(roll2))
        }});

        final Location currentLocation = // set to your desired test loc...    

        context.checking(new Expectations() {{
            oneOf (p).getLocation();
            will(returnValue(currentLocation));
        }});

        final Square newLoc = new Square();

        context.checking(new Expectations() {{
            oneOf (b).getSquare(currentLocation, roll1 + roll2);
            will(returnValue(newLoc));
        }});


        context.checking(new Expectations() {{
            oneOf (p).setLocation(newLoc);
        }});

        pl.takeTurn(d,p,b);

        context.assertIsSatisfied();
    }
}