try
    {
    clip = AudioSystem.getClip();
    this.clip = clip;
    ...
    }

    else
        {
        clip.stop();
        }