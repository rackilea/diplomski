@Override
public void onResponse(Call<ObjectList> call, Response<ObjectList> response) {
       StringBuilder sb = new StringBuilder(); // add this line

       for(int i=0; i<response.body().getHardware().length; i++){
           Log.e(" mainAction", "  hardware"+ response.body().getHardware()[i].name);

           sb.append(response.body().getHardware()[i].name)); // here we append each hardware name to our string builder.
           sb.append(" "); // here we append a space separator after every hardware name, you can use whatever you want(like: newline[\n] or coma[,]).
       }
       textviewhardware.setText(sb.toString()); // now textview will show every hardware name.
}