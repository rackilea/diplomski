String[] temp = line.split(",");
instrument_audio_file_list.add(temp[0]);

if (temp.length > 1) {
    instrument_title_list.add(temp[1]);
} else {
    instrument_title_list.add("");
}