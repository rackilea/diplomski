fd = FileDialog(self, "Scegli un'immagine", FileDialog.LOAD)
fd.setFile(';*.'.join(("*.bmp","jpg","jpeg","wbmp","png","gif")))
fd.setVisible(True)
self.imgName = fd.getFile()
relativePath = fd.getDirectory() + fd.getFile() """Here is the missing piece!"""
if self.imgName != None:
   self.imgAbsPath = os.path.abspath(relativePath) """Here the absolute path is correctly obtained!"""
   self.bigDict['imgButton'].setIcon(ImageIcon(ImageIcon(self.imgAbsPath).getImage().getScaledInstance(130, 130, Image.SCALE_DEFAULT)))
   """The image, before being inserted into the button, is slightly resized, to avoid graphic bumps!"""