firstbullet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    secondbullet..setVisibility(View.GONE);
                }
            });

    secondbullet.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // TODO Auto-generated method stub
                    firstbullet..setVisibility(View.GONE);
                }
            });