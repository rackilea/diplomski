HRESULT
RunProgramInGuest([in] BSTR guestProgramName,
                  [in] BSTR commandLineArgs,
                  [in] LONG options,
                  [in] IVixHandle* propertyList,
                  [in] ICallback* jobDoneCallback,
                  [out,retval] IJob** runJob);