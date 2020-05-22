public onCreatingView = (args:any)=>{
        if(androidApp){
          var appContext = androidApp.context ;
          this.mtextureview = new android.view.TextureView(androidApp.context);
          this.mtextureview.setSurfaceTextureListener(this.msurfaceTextureLisitiner);
          args.view = this.mtextureview ;

        }if(iosApp){
          console.log("running on ios");
        }
  }
  //the method surfaceTextureListiner callback from the interface
  public msurfaceTextureLisitiner = new android.view.TextureView.SurfaceTextureListener({
    onSurfaceTextureAvailable : (texture,width,height)=>{
      console.log('texture avlaible');
      this.mcamera = android.hardware.Camera.open(this.cid);
      var params:android.hardware.Camera.Parameters = this.mcamera.getParameters();
      this.mcamera.setDisplayOrientation(90);
      params.set("orientation", "portrait");
      this.mcamera.setParameters(params); 
      this.mtextureview = texture;
      try{
          this.mcamera.setPreviewTexture(texture);
          this.mcamera.startPreview();
      }catch(e){
        console.log(e);
      }

    },
    onSurfaceTextureSizeChanged : (texture,width,height)=>{
      console.log('size changed');
    },
    onSurfaceTextureDestroyed : (texture)=>{
         console.log('surface destroyed');
         this.mcamera.stopPreview();
         this.mcamera.release();
         return true;
    },
    onSurfaceTextureUpdated : (texture)=>{
      console.log("texture updated");
    }
});