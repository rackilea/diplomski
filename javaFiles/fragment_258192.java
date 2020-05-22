//---------------------------------------------------------------------------
//--- multi band rendering --------------------------------------------------
//---------------------------------------------------------------------------
const int _Bands=10;                            // number of bands used
double _Band_RGB[_Bands][3];                    // RGB of each band with white bias correction
double _Band_Wavelength[_Bands];                // wavelength of each band
//---------------------------------------------------------------------------
void wavelength2RGB(double *rgb,double lambda)  // RGB <0,1> <- lambda <400e-9,700e-9> [m]
    {
    double r=0.0,g=0.0,b=0.0,t;
         if ((lambda>=400.0e-9)&&(lambda<410.0e-9)) { t=(lambda-400.0e-9)/(410.0e-9-400.0e-9); r=    +(0.33*t)-(0.20*t*t); }
    else if ((lambda>=410.0e-9)&&(lambda<475.0e-9)) { t=(lambda-410.0e-9)/(475.0e-9-410.0e-9); r=0.14         -(0.13*t*t); }
    else if ((lambda>=545.0e-9)&&(lambda<595.0e-9)) { t=(lambda-545.0e-9)/(595.0e-9-545.0e-9); r=    +(1.98*t)-(     t*t); }
    else if ((lambda>=595.0e-9)&&(lambda<650.0e-9)) { t=(lambda-595.0e-9)/(650.0e-9-595.0e-9); r=0.98+(0.06*t)-(0.40*t*t); }
    else if ((lambda>=650.0e-9)&&(lambda<700.0e-9)) { t=(lambda-650.0e-9)/(700.0e-9-650.0e-9); r=0.65-(0.84*t)+(0.20*t*t); }
         if ((lambda>=415.0e-9)&&(lambda<475.0e-9)) { t=(lambda-415.0e-9)/(475.0e-9-415.0e-9); g=             +(0.80*t*t); }
    else if ((lambda>=475.0e-9)&&(lambda<590.0e-9)) { t=(lambda-475.0e-9)/(590.0e-9-475.0e-9); g=0.8 +(0.76*t)-(0.80*t*t); }
    else if ((lambda>=585.0e-9)&&(lambda<639.0e-9)) { t=(lambda-585.0e-9)/(639.0e-9-585.0e-9); g=0.84-(0.84*t)           ; }
         if ((lambda>=400.0e-9)&&(lambda<475.0e-9)) { t=(lambda-400.0e-9)/(475.0e-9-400.0e-9); b=    +(2.20*t)-(1.50*t*t); }
    else if ((lambda>=475.0e-9)&&(lambda<560.0e-9)) { t=(lambda-475.0e-9)/(560.0e-9-475.0e-9); b=0.7 -(     t)+(0.30*t*t); }
    rgb[0]=r;
    rgb[1]=g;
    rgb[2]=b;
    }
//---------------------------------------------------------------------------
double wavelength2int(double lambda)                // white bias correction intensity <0,1+> <- lambda <400e-9,700e-9> [m]
    {                                               // this is mine empirically deduced equation and works for evenly distributed bands
    const double a0=  8.50/double(_swColorWavelengths);// for 3-5 bands low bias, >5 almost no visible bias present
    const double a1=-27.37/double(_swColorWavelengths);
    const double a2=+26.35/double(_swColorWavelengths);
    double t=divide(lambda-400e-9,700e-9-400e-9);
    return (a0)+(a1*t)+(a2*t*t);
    }
//---------------------------------------------------------------------------
void init_multiband_colors()                    // init evenly distributed bands through visible spectrum range
    {
    double l,dl; int ix;
    l=405e-9; dl=695e-9; dl=divide(dl-l,_Bands); l+=0.5*dl;
    for (ix=_Bands-1;ix>=0;ix--,l+=dl)          // init colors and wavelengths (multispectral rendering)
        {
        _Band_Wavelength[ix]=l;
        wavelength2RGB(_Band_RGB[ix],l);
        _Band_RGB[ix][0]*=wavelength2int(l);    // white bias removal
        _Band_RGB[ix][1]*=wavelength2int(l);
        _Band_RGB[ix][2]*=wavelength2int(l);
        }
    }
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------
//---------------------------------------------------------------------------