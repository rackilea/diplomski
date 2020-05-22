what_you_need_to_make_it_above_ground=(ground_y-feet_y);


  //im not sure if dy is ground level so i added second boolean compare

  if ((dy < 4)||(ground_y>feet_y)) {
                 dy += 0.1; // this isnt enough. should be equal to:
                 dy +=what_you_need_to_make_it_above_ground;
                 dy +=if_there_are_other_parameters_think_of_them_too;

              }