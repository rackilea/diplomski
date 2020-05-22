//Anonymous class Myrtle from Plant interface
Plant myrtle = new Plant() {
          @Override
          public void grow() {
               System.out.println("This was running from anonymous class from Plant Interface");
          }
};
myrtle.grow();