public ZipFile(File file, int mode, Charset charset) throws IOException
{
    /* snip */
    this.zc = ZipCoder.get(charset);
    /* snip */
}

static ZipCoder get(Charset charset) {
    return new ZipCoder(charset);
}