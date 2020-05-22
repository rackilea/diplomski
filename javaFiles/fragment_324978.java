// Metodo que manda pra nuvem
public static void mandarNuvem(final Context context,Restaurante rest){

Metodos.taskInProgres(true, context);

    ParseObject restauranteParse = new ParseObject("Restaurante");
    restauranteParse.put("nomeRestaurante", rest.getNomeRest());
    restauranteParse.put("emailRestaurante", rest.getEmailRest());
    restauranteParse.put("telefoneRestaurante", rest.getTelefoneRest());
    restauranteParse.saveInBackground(new SaveCallback() {
        @Override
        public void done(ParseException e) {
            if (e == null) {
                Toast.makeText(context,"Salvo com sucesso!", Toast.LENGTH_SHORT).show();
                Metodos.taskInProgres(false, context);
            } else {
                Toast.makeText(context, e.getMessage(),Toast.LENGTH_SHORT).show();
            }
        }
    });
 }