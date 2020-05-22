if (Pepperoni.isChecked() && Ex_Cheese.isChecked() == false){
    if(Pepperoni.isChecked() && GreenPep.isChecked() && Sausage.isChecked() == false ){
        image.setImageResource(R.drawable.f_pep_gp);
    } else if(Pepperoni.isChecked() && Sausage.isChecked() && GreenPep.isChecked() == false){
        image.setImageResource(R.drawable.c_pep);
    } else if(Pepperoni.isChecked() && GreenPep.isChecked() && Sausage.isChecked()){
        image.setImageResource(R.drawable.p_pep_gp_sau);
    } else {
        image.setImageResource(R.drawable.c_pep);
    }