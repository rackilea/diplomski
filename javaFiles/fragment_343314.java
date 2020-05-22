if(Main.songService.svc_mpcontroller != null && Main.global_music_controller != null) {
        if (AL_songlist.get(position).getID() == Main.global_music_controller.get_current_id()) {
            ColorStateList sColorStatePlaying;
            ColorStateList sColorStateNotPlaying;

            sColorStatePlaying = ColorStateList.valueOf(context.getResources().getColor(R.color.colorPrimary));
            AnimationDrawable animation = (AnimationDrawable) ContextCompat.getDrawable(context, R.drawable.anim_current_song);
            holder.imgEQAnimation.setVisibility(View.VISIBLE);
            holder.imgEQAnimation.setImageDrawable(animation);
            holder.imgEQAnimation.setImageTintList(sColorStatePlaying);
            animation.start();
        }
    }
    else
        holder.imgEQAnimation.setVisibility(View.GONE);