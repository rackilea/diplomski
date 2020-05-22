// create a context with the namespace
namespace Media.Decoders
{
  // start interfaces with an I
  IDataHandler { ... }

  // name classes descriptively 
  class BitmapHandler : IDataHandler
  class VideoHandler : IDataHandler
  class SoundHandler : IDataHandler
}

// example if these handlers were decoding media types
// imagine navigating through the structure section by section
MyLibrary.Media.Decoders.BitmapHandler
// if everything is grouped logically if I were looking for an encoder a natural place to look would be
MyLibrary.Media.Encoders.BitmapHandler