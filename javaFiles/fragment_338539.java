DefaultFontMapper mapper = new DefaultFontMapper();
mapper.insertDirectory("c:/windows/fonts");
DefaultFontMapper.BaseFontParameters pp = mapper.getBaseFontParameters("Arial Unicode MS");
if (pp!=null) {
    pp.encoding = BaseFont.IDENTITY_H;
}