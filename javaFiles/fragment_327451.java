public static void main (String[] args) {

    Playeri user = new Playeri();

    Enemyu enem = new Enemyu();

    Scanner input = new Scanner(System.in);

    user.name = input.nextLine();

    user.showName();

    enem.showUserName();

    }

    }

    class Playeri {

        String name;

        void showName() {

        System.out.println("Your name is " + name + ".");
        Enemyu.enemUser.name=name; // Set it like this
        }

        }

        class Enemyu {

        static Playeri enemUser = new Playeri(); // make it static

        void showUserName() {

        System.out.println("Hey, bro! Are you " + enemUser.name + "?");

        }

        }