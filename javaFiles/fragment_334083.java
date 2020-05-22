@Override
 public void onResponse(Call<List<Message>> call,  retrofit2.Response<List<Message>> response) {
            messages.clear;
            // TODO - avoid looping
            for ( Message message : response.body()) {
                // generate a random color
                message.setColor(getRandomMaterialColor("400"));
                messages.add(message);
            }

            mAdapter.notifyDataSetChanged();

        }