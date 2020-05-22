// Reference to an image file in Cloud Storage
StorageReference storageReference = ...;

// ImageView in your Activity
ImageView imageView = ...;

// Download directly from StorageReference using Glide
// (See MyAppGlideModule for Loader registration)
GlideApp.with(this /* context */)
        .load(storageReference)
        .into(imageView);