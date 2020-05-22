int style = 0;
int size = 12;
if (small.isSelected()){size=12;/*area.setFont(smalla);*/}
else if (medium.isSelected()){size=14;/*area.setFont(med);*/}
else if (large.isSelected()){size=20;/*area.setFont(la);*/}
if (bold.isSelected()){ 
    style |=Font.BOLD /*area.setFont(new Font(Font.SANS_SERIF, style,  style))*/;
} 
if (italic.isSelected()){
    style |=Font.ITALIC /area.setFont(new Font(Font.SANS_SERIF, style, style))/;
} 
if (underline.isSelected()){
    style |=Font.CENTER_BASELINE /area.setFont(new Font(Font.SANS_SERIF, style, style))/;
}