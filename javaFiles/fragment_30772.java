Glide.with(context)
                .load(currentBlock.getImage1ResourceId())
                .placeholder(R.drawable.placeholder)   //Use low res image as placeholder
                .error(R.drawable.imagenotfound)      //Use low res image as error image
                .into(iconView1);

 Glide.with(context)
                .load(currentBlock.getImage2ResourceId())                   
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.imagenotfound)
                .into(iconView2);