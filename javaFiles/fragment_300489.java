import java.util.*;

public class Spookster

{
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System. in );
        int actionOne, actionTwo, actionThree, actionFour, actionFive, actionSix, actionSeven, actionEight, actionNine;

        System.out.println("You wake up in a metallic room. There is a knife next to you, and there is a door ahead of you.");
        System.out.print("Enter 1 to go to the door, enter 2 to pick up the knife: ");
        actionOne = keyboard.nextInt();

        if (actionOne == 1) {
            System.out.println(" ");
            System.out.println("You walk to the door. There is a small window that you could look through.");
            System.out.println("You could also just open the door right there.");
            System.out.print("Enter 1 to look through the window, enter 2 to go through the door: ");
            actionTwo = keyboard.nextInt();
            if (actionTwo == 1) {
                System.out.println(" ");
                System.out.println("You look through the window and see a tall creature inside a cockpit.");
                System.out.println("Suddenly you are grabbed from behind and everything is black");
                System.out.println("YOU ARE DEAD");
            } else if (actionTwo == 2) {
                System.out.println(" ");
                System.out.println("You open the door and hear something behind you, you shut it fast then are in shock");
                System.out.println("Another creature is staring you down in front of you. He runs at you with a electrical sword");
                System.out.print("Enter 1 to dodge, enter 2 to defend yourself: ");
            }

        } else if (actionOne == 2) {
            System.out.println(" ");
            System.out.println("You pick up the knife and hear something behind you.");
            System.out.println("You blindly throw your hand backwards and realise you killed a tall creature.");
            System.out.println("There is an advanced gun in his hand");
            System.out.print("Enter 1 to pick up the gun, enter 2 to leave it be: ");
            actionThree = keyboard.nextInt();

            if (actionThree == 1) {
                System.out.println(" ");
                System.out.println("You grab the gun and the creature moves, you quickly aim and fire");
                System.out.println("The creature drops dead. You take a look around and notice a corridor.");
                System.out.println("You head down the corridor and it splits.");
                System.out.print("Enter 1 to head left, enter 2 to head right: ");
                actionFour = keyboard.nextInt();
                if (actionFour == 1) {
                    System.out.println(" ");
                    System.out.println("You head left. There is a control panel that controls an escape pod");
                    System.out.println("There are two buttons, a blue button and a yellow button.");
                    System.out.print("Enter 1 to press the blue button, enter 2 to press the yellow button: ");
                    actionFive = keyboard.nextInt();
                    if (actionFive == 1) {
                        System.out.println(" ");
                        System.out.println("You press the blue button. The ship begins to shake.");
                        System.out.println("You take your last breath as the ship explodes");
                        System.out.println(" ");
                        System.out.println("YOU ARE DEAD");
                    } else if (actionFive == 2) {
                        System.out.println(" ");
                        System.out.println("You press the yellow button. The escape pod door opens.");
                        System.out.println("You walk inside and hear something behind you.");
                        System.out.println("There are two switches in an alien language. One must control the door.");
                        System.out.print("Enter 1 to activate the left switch, enter 2 to activate the right switch.");
                        actionSeven = keyboard.nextInt();
                        if (actionSeven == 1) {
                            System.out.println(" ");
                            System.out.println("You activate the left switch and the hatch closes.");
                            System.out.println("There is only one other switch, you activate it.");
                            System.out.println("The escape pod launches from the ship. On the descent down you see the alien ship come towards earth.");
                            System.out.println("Seconds later the ship is blown to bits. Once you land you are greeted by a govenment agency");
                            System.out.println("They thank you for baiting the ship in, and give you a medal for your accomplishments.");
                            System.out.println(" ");
                            System.out.println(" ");
                            System.out.println("YOU SURVIVED - BAD ENDING");
                        } else if (actionSeven == 2) {
                            System.out.println(" ");
                            System.out.println("You activate the right switch and the escape pod launches into space.");
                            System.out.println("You see the alien bodies fly out of the ship before your eyes pop");
                            System.out.println(" ");
                            System.out.println("YOU ARE DEAD");
                        }
                    }
                } else if (actionFour == 2) {
                    System.out.println(" ");
                    System.out.println("You head right. There is an armory filled with alien weapons.");
                    System.out.print("Enter 1 to get an alien rifle, enter 2 to leave the weapons and continue down the hall: ");
                    actionSix = keyboard.nextInt();
                    if (actionSix == 1) {
                        System.out.println(" ");
                        System.out.println("You pick up an alien rifle. It sends off an alarm.");
                        System.out.println("Multiple aliens are rushing down the halls. You pick off a few.");
                        System.out.println("Suddenly you feel pain in your stomache and you drop to the floor.");
                        System.out.println(" ");
                        System.out.println("YOU ARE DEAD");
                    } else if (actionSix == 2) {
                        System.out.println(" ");
                        System.out.println("You decide it's not worth the risk.");
                        System.out.println("You keep heading down the corridor and find some type of needle filled with liquid.");
                        System.out.print("Enter 1 to inject the liquid into you, enter 2 to leave it: ");
                        actionEight = keyboard.nextInt();
                        if (actionEight == 1) {
                            System.out.println(" ");
                            System.out.println("You inject the liquid and see your arms and body slowly vanish.");
                            System.out.println("It seems you injected yourself with a cloaking syrum.");
                            System.out.println("Seconds later an alien comes in. It growls then moves off looking for you.");
                            System.out.println("Heading down the corridor you see another alien, this one looks different.");
                            System.out.println("It wears a cloak and crown, and looks to be of high status.");
                            System.out.print("Enter 1 to attempt to communicate, enter 2 to remain silent: ");
                            actionNine = keyboard.nextInt();
                            if (actionNine == 1) {
                                System.out.println(" ");
                                System.out.println("You speak in english 'Why am I here?!'");
                                System.out.println("To your surprise the alien responds in English");
                                System.out.println("He says 'We were testing humans, you seem like a smart one");
                                System.out.println("He says 'I would like to take you back to our home system.'");
                                System.out.println("He says 'After seeing what you can do, I believe you could help us in our galactic republic'");
                                System.out.println(" ");
                                System.out.println("1 Year Later");
                                System.out.println("You are now part of a galactic republic lightyears away. You have forgotten your old life.");
                                System.out.println("Something has made you forget it, but that doesn't matter now. You are a part of their military.");
                                System.out.println("You don't question their motives, because you have no reason to.");
                                System.out.println(" ");
                                System.out.println(" ");
                                System.out.println("YOU SURVIVED - GOOD ENDING");
                            } else if (actionNine == 2) {
                                System.out.println(" ");
                                System.out.println("You suddenly feel weak. A crunching feeling is in your body.");
                                System.out.println("It seems the alien knew you were there. He is much more powerful than the rest.");
                                System.out.println("Your insides begin to hurt until blood bursts from your stomach, you fall to the ground.");
                                System.out.println(" ");
                                System.out.println("YOU ARE DEAD");
                            }
                        } else if (actionEight == 2) {
                            System.out.println(" ");
                            System.out.println("You leave the needle there.");
                            System.out.println("Suddenly a blade pierces through you. An alien has sneaked up on you.");
                            System.out.println("As your vision fades to black, you feel absolute terror.");
                            System.out.println(" ");
                            System.out.println(" ");
                        }
                    }
                }
            } else if (actionThree == 2) {
                System.out.println(" ");
                System.out.println("The creature becomes conscious and aims the gun at you, you stand in fear.");
                System.out.println("Suddenly you hear a loud noise and everything is black.");
                System.out.println(" ");
                System.out.println("YOU ARE DEAD");
            }
        }
    }
}