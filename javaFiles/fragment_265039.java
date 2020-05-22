ProcessBuilder builder = new ProcessBuilder(
    "C:\\Pythion27\\Python.exe",
    "H:\\!eGIS.Dev_Workbench\\eGIS.ArcGIS_Workbench\\!eGIS.Network_Build\\Network_Build_Script.v.6.2_2017.12.08\\Script.1-2_Trunk_20170609\\Src\\PY\\ComcastNetworkProcessing\\ComcastNetworkProcessing.py",
    "H:\\!eGIS.Dev_Workbench\\eGIS.ArcGIS_Workbench\\!eGIS.Network_Build\\eGIS.CoE.Network_Clips\\Network_ETLs\\eGIS.CoE.Network_Clip\\MOUNTAINWEST_AZ.gdb",
    "H:\\!eGIS.Dev_Workbench\\eGIS.ArcGIS_Workbench\\!eGIS.Network_Build\\Network_DS_ProBuild\\Wp4\\Network_Build_00_00_0000\\WD_Mountainwest_AZ");

builder.redirectOutput(new File(
    "H:\\!eGIS.Dev_Workbench\\eGIS.ArcGIS_Workbench\\!eGIS.Network_Build\\Network_DS_ProBuild\\Wp4\\Network_Build_00_00_0000\\WD_Mountainwest_AZ\\logs\\BBB2_NB_Script1_AZ.txt"));