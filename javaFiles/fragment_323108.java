Bitmap b = new Bitmap(Image.FromFile(@"C:\Temp\water.jpg"));
// create filter
Edges filter = new Edges();
// apply the filter
filter.ApplyInPlace(b);

pictureBox1.Image = b;