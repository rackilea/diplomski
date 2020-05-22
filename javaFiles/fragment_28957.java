try {
 myNumber.number = Integer.parseInt(usersNumber.getText().toString());


        if (usersNumber.getText().toString().isEmpty()) {


            msg = myNumber.number + "Please eneter a Number!";

        } else {


            if (myNumber.isSquare()) {

                if (myNumber.isTriangular()) {

                    msg = myNumber.number + "is both square and triangular!";
                } else {

                    msg = myNumber.number + "is square but not traingular";


                }


            } else {


                if (myNumber.isTriangular()) {

                    msg = myNumber.number + "is triangular but not suqare !";
                } else {

                    msg = myNumber.number + "is neither";
                }


            }




        }
}catch (NumberFormatException ne){
  //handle the exception
}