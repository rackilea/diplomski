import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        new Main().testBuyHouse();
    }

    public void testBuyHouse() {
        Player player = new Player(1000000, 0);
        GameboardSquare property = new GameboardSquare("Seb", 100, 50, 50, 100, 150, 200, 250, 300, 200, 0, 3, 0, player, false);
        GameboardSquare[] gameboard = new GameboardSquare[3];
        gameboard[0] = property;
        GameLogic game = new GameLogic(gameboard);
        Board board = new Board(gameboard);
        board.setMonopolyBoard(gameboard);
        game.buyHouse(player, 0);
    }
}

class GameLogic extends Board {
    Scanner input = new Scanner(System.in);

    public GameLogic(GameboardSquare[] monopolyBoard) {
        super(monopolyBoard);
    }

    public boolean buyHouse(Player player, int propertyIndex) {
        boolean boughtHouse = false;
        GameboardSquare property = getMonopolyBoard()[propertyIndex];
        if (property.getNumberHouse() <= 3) {
            System.out.println("How many houses you want to buy? it must be between 1-4: ");
            int numHouseToBuy = input.nextInt();
            System.out.println(numHouseToBuy);
            while (numHouseToBuy > 4) {
                System.out.println("To much to buy only 1-4");
                System.out.println("How many houses you want to buy? it must be between 1-4");
                numHouseToBuy = input.nextInt();
            }
            //think over the logic of the this switch statement
            switch (numHouseToBuy) {
                case 1:
                    if (numHouseToBuy + property.getNumberHouse() <= 4) {
                        player.setcurrentMoney(player.getcurrentMoney() - property.getHouseCost());
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                        System.out.println("boughtHouse");
                    } else {
                        //need to copy this to the other switch
                        System.out.println("To many houses on this property");
                        System.out.println("You can only buy " + (4 - property.getNumberHouse()));
                        numHouseToBuy = input.nextInt();
                        while (numHouseToBuy + property.getNumberHouse() > 4) {
                            System.out.println("To many houses on this property");
                            numHouseToBuy = 4;
                        }
                        player.setcurrentMoney(player.getcurrentMoney() - property.getHouseCost());
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    }
                    break;
                case 2:
                    if (numHouseToBuy + property.getNumberHouse() <= 4) {
                        player.setcurrentMoney(player.getcurrentMoney() - (property.getHouseCost() * 2));
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    } else {
                        System.out.println("To many houses on this property");
                        numHouseToBuy = 4;
                        while (numHouseToBuy + property.getNumberHouse() > 4) {
                            System.out.println("To many houses on this property");
                            numHouseToBuy = 4;
                        }
                        player.setcurrentMoney(player.getcurrentMoney() - property.getHouseCost());
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    }
                    break;
                case 3:
                    if (numHouseToBuy + property.getNumberHouse() <= 4) {
                        player.setcurrentMoney(player.getcurrentMoney() - (property.getHouseCost() * 3));
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    } else {
                        System.out.println("To many houses on this property");
                        numHouseToBuy = 4;
                        while (numHouseToBuy + property.getNumberHouse() > 4) {
                            System.out.println("To many houses on this property");
                            numHouseToBuy = 4;
                        }
                        player.setcurrentMoney(player.getcurrentMoney() - property.getHouseCost());
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    }
                    break;
                case 4:
                    if (numHouseToBuy + property.getNumberHouse() <= 4) {
                        player.setcurrentMoney(player.getcurrentMoney() - (property.getHouseCost() * 4));
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    } else {
                        System.out.println("To many houses on this property");
                        System.out.println("You can only buy " + (4 - property.getNumberHouse()));
                        numHouseToBuy = input.nextInt();
                        while (numHouseToBuy + property.getNumberHouse() > 4) {
                            System.out.println("To many houses on this property");
                            numHouseToBuy = 4;
                        }
                        player.setcurrentMoney(player.getcurrentMoney() - property.getHouseCost());
                        property.setNumberHouse(property.getNumberHouse() + numHouseToBuy);
                        boughtHouse = true;
                    }
                    break;
                default:
                    break;
            }
            return boughtHouse;
        } else {
            System.out.println("You own 4 houses on this property already");
            return boughtHouse;
        }
    }
}

class Board {
    private GameboardSquare[] monopolyBoard;
    private Player player1;
    private Player player2;

    Board(GameboardSquare[] monopolyBoard) {
        this.monopolyBoard = monopolyBoard;
    }
//    public Board(){
////        monopolyBoard = new GameboardSquare[40];
//    }

    public void setupGameBoard(File propertySquares) throws Exception {
        Scanner input1 = new Scanner(System.in);
        GameboardSquare a;
        while (input1.hasNextLine()) {
            int index = 0;
            String property = input1.nextLine();
            String[] propertySqaure = property.split(",");
            // TODO: 11/15/2016 add other sqaure file some how
            switch (index) {
                case 0:
                    a = new GameboardSquare("Go", 0, 0, 0, 0, 0, 0, 0, 0, 0, 200, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 2:
                    //community chest
                    a = new GameboardSquare("Community Chest", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 4:
                    //income tax
                    break;
                case 7:
                    //chance
                    a = new GameboardSquare("Chance", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 10:
                    //visit jail
                    a = new GameboardSquare("Just Visiting Jail", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 17:
                    //community chest
                    a = new GameboardSquare("Community Chest", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 20:
                    //free parking
                    a = new GameboardSquare("Free Parking", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 22:
                    //chance
                    a = new GameboardSquare("Chance", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 40:
                    //go to jail
                    a = new GameboardSquare("Go To Jail", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 43:
                    //community chest
                    a = new GameboardSquare("Community Chest", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 46:
                    ///chance
                    a = new GameboardSquare("Chance", 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, null, false);
                    monopolyBoard[index++] = a;
                    break;
                case 48:
                    //luxury tax
                    break;
                default:
                    a = parseMethod(propertySqaure);
                    monopolyBoard[index++] = a;
                    break;
            }
        }
    }

    GameboardSquare parseMethod(String[] propertySqaure) {
        String propertyName = propertySqaure[0];
        int value = Integer.parseInt(propertySqaure[1]);
        int rent = Integer.parseInt(propertySqaure[3]);
        int rent1 = Integer.parseInt(propertySqaure[4]);
        int rent2 = Integer.parseInt(propertySqaure[5]);
        int rent3 = Integer.parseInt(propertySqaure[6]);
        int rent4 = Integer.parseInt(propertySqaure[7]);
        int hotel = Integer.parseInt(propertySqaure[8]);
        int mortgage = Integer.parseInt(propertySqaure[9]);
        int houseCost = Integer.parseInt(propertySqaure[2]);
//        int hotelCost = Integer.parseInt(propertySqaure[2]);
        int moneyGive = Integer.parseInt(propertySqaure[10]);
        Player owner = null;
        GameboardSquare a = new GameboardSquare(propertyName, value, houseCost, rent, rent1, rent2, rent3, rent4, hotel, mortgage, moneyGive, 0, 0, owner, false);
        return a;
    }

    GameboardSquare[] getMonopolyBoard() {
        return monopolyBoard;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setMonopolyBoard(GameboardSquare[] monopolyBoard) {
        this.monopolyBoard = monopolyBoard;
    }
}


class Player {
    private int currentMoney;
    private int moveIndex;

    public Player(int currentMoney, int moveIndex) {
        this.moveIndex = moveIndex;
        this.currentMoney = currentMoney;
    }


    public void moves(Player player, int moves) {
        int a = player.getMoveIndex() + moves;
        if (a > 41) {
            int b = a - 40;
            player.setMoveIndex(b);
            if (player.getMoveIndex() != 0) {
                player.setcurrentMoney(player.getcurrentMoney() + 200);
            }
        } else {
            player.setMoveIndex(a);
        }
    }


    public int getcurrentMoney() {
        return currentMoney;
    }

    public void setcurrentMoney(int currentMoney) {
        this.currentMoney = currentMoney;
    }

    public int getMoveIndex() {
        return moveIndex;
    }

    public void setMoveIndex(int moveIndex) {
        this.moveIndex = moveIndex;
    }
}

class GameboardSquare {
    private String squareName;
    private int cost;
    private int hotel;
    private int rent;
    private int moneyGive;
    private int rent1;
    private int rent2;
    private int rent3;
    private int rent4;
    private int mortgage;
    private int houseCost;
    private int hotelCost;
    private int numberHouse;
    private int numberHotels;
    private boolean hasMortgage;
    private Player propertyOwner;

    //todo add player owns var and player mortgage var
    GameboardSquare(String squareName, int cost, int houseCost, int rent, int rent1, int rent2, int rent3,
                    int rent4, int hotel, int mortgage, int moneyGive, int numberHouse, int numberHotels, Player owner, boolean hasMortgage) {
        this.squareName = squareName;
        this.cost = cost;
        this.hotel = hotel;
        this.rent = rent;
        this.moneyGive = moneyGive;
        this.rent1 = rent1;
        this.rent2 = rent2;
        this.rent3 = rent3;
        this.rent4 = rent4;
        this.mortgage = mortgage;
        this.houseCost = houseCost;
        this.numberHouse = numberHouse;
        this.numberHotels = numberHotels;
        this.hasMortgage = hasMortgage;
        this.propertyOwner = owner;//// TODO: 11/15/2016 make a more specific
    }

    public boolean hasHouse(Player player, GameboardSquare[] monopolyBoard) {
        return monopolyBoard[player.getMoveIndex()].getNumberHouse() > 0;
    }

    public boolean hasHotel(Player player, GameboardSquare[] monopolyBoard) {
        return monopolyBoard[player.getMoveIndex()].getNumberHotels() > 0;
    }

    public String getSquareName() {
        return squareName;
    }

    public void setSquareName(String squareName) {
        this.squareName = squareName;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getHotel() {
        return hotel;
    }

    public void setHotel(int hotel) {
        this.hotel = hotel;
    }

    public int getRent() {
        return rent;
    }

    public void setRent(int rent) {
        this.rent = rent;
    }

    public int getMoneyGive() {
        return moneyGive;
    }

    public void setMoneyGive(int moneyGive) {
        this.moneyGive = moneyGive;
    }

    public int getRent1() {
        return rent1;
    }

    public void setRent1(int rent1) {
        this.rent1 = rent1;
    }

    public int getRent2() {
        return rent2;
    }

    public void setRent2(int rent2) {
        this.rent2 = rent2;
    }

    public int getRent3() {
        return rent3;
    }

    public void setRent3(int rent3) {
        this.rent3 = rent3;
    }

    public int getRent4() {
        return rent4;
    }

    public void setRent4(int rent4) {
        this.rent4 = rent4;
    }

    public int getMortgage() {
        return mortgage;
    }

    public void setMortgage(int mortgage) {
        this.mortgage = mortgage;
    }

    public int getHouseCost() {
        return houseCost;
    }

    public void setHouseCost(int houseCost) {
        this.houseCost = houseCost;
    }

    public int getHotelCost() {
        return hotelCost;
    }

    public void setHotelCost(int hotelCost) {
        this.hotelCost = hotelCost;
    }

    public int getNumberHouse() {
        return numberHouse;
    }

    public void setNumberHouse(int numberHouse) {
        this.numberHouse = numberHouse;
    }

    public int getNumberHotels() {
        return numberHotels;
    }

    public void setNumberHotels(int numberHotels) {
        this.numberHotels = numberHotels;
    }

    public boolean isHasMortgage() {
        return hasMortgage;
    }

    public void setHasMortgage(boolean hasMortgage) {
        this.hasMortgage = hasMortgage;
    }

    public Player getPropertyOwner() {
        return propertyOwner;
    }

    public void setPropertyOwner(Player propertyOwner) {
        this.propertyOwner = propertyOwner;
    }
}