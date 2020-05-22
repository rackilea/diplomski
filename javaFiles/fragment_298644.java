Presentation pres=new Presentation("Test.pptx");
//Getting Orientation
//SlideOrienation 0: Landscape 1: Portrait
int orientation=pres.getSlideSize().getOrientation();

//Setting orientation
pres.getSlideSize().setOrientation(SlideOrienation.Portrait);

//Setting Slide size
// Method SetSize is used for set slide size with scale content to ensure fit
pres.getSlideSize().setSize(720, 540, SlideSizeScaleType.EnsureFit);

// Method SetSize is used for set slide size with maximize size of content
pres.getSlideSize().setSize(SlideSizeType.A4Paper, SlideSizeScaleType.Maximize);

//Getting SlideSizeType: Read only property
int SizeType= pres.getSlideSize().getType();

//Getting slide Size: Read only property
Dimension2D slideSize=pres.getSlideSize().getSize();