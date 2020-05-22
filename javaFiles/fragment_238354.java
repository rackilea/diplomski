jwplayer("<?php echo $this->id?>").setup({

                autostart: 'true' ,
                flashplayer: "<?php echo CHtml::asset($this->_path.'/jwplayer.flash.swf')?>",
                width:<?php echo $this->width?>,
                height:<?php echo $this->height?>,
                playlist: [{
                    sources: [
                    {
                       //Desktop: Use RTMP protocol and played by flash.
                        file: "<?php echo $this->rtmpPath;?>"
                    },
                    {
                        //Mobile: Use HLS protocol and played by HTML5
                        file: "<?php echo $this->hlsPath;?>",
                    }
                    ]
                }],
                primary:"flash",
            });