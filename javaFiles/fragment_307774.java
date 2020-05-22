double volumeBase = 4 * piDouble * radius * radius * radius / 3;

double volume;
if(inputPref.equalsIgnoreCase("mm") && outputPref.equalsIgnoreCase("cubic cm")){
    volume = volumeBase / 1000;
}
else if(inputPref.equalsIgnoreCase("mm") && outputPref.equalsIgnoreCase("cubic metres")){
    volume = volumeBase / 1000000000;
}
else if(inputPref.equalsIgnoreCase("cm") && outputPref.equalsIgnoreCase("cubic mm")){
    volume = volumeBase * 1000;
}
else if(inputPref.equalsIgnoreCase("cm") && outputPref.equalsIgnoreCase("cubic metres")){
    volume = volumeBase / 1000000;
}
else if(inputPref.equalsIgnoreCase("metres") && outputPref.equalsIgnoreCase("cubic mm")){
    volume = volumeBase * 1000000000;
}
else if(inputPref.equalsIgnoreCase("metres") && outputPref.equalsIgnoreCase("cubic cm")){
    volume = volumeBase * 1000000;
}
else {
    volume = 10;
}