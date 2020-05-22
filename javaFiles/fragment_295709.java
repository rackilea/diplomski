class OphirPyCOM:

    _reg_clsid_ = "{PYTHON-COM-CLSID-HERE}"
    _reg_desc_ = "Python COM server"
    _reg_progid_ = "Python COM server"
    _public_methods_ = [    'Hello', 
                            'ConnectOphir', 
                            'ScanUSB', """More methods here"""
                            ]
    _public_attrs_ = ["""Some public attributes"""]
    _readonly_attrs_ = ["""some read-only attributes"""]

    def __init__(self):
        """some variables declared here"""

    def Hello(self, who):
        """Verifies a connection"""
        return "{PYTHON-COM-CLSID-HERE}" + str(who) 

    def ConnectOphir(self,clsid):
        """Connects to the target COM Object"""
        from comtypes.client import CreateObject
        self.target_guid = CreateObject(clsid)
        return "OphirLMMeasurement object created."

    def ScanUSB(self):
        """Communicates with the target device"""
        self.connected_inst = self.target_guid.ScanUSB()
        for i in range(0,len(self.connected_inst)):
            self.inst_list.append(str(self.connected_inst[i]))
        return self.inst_list

if __name__ == "__main__":
    # use 'python com.py' to register the COM server
    # use 'python com.py --unregister' to unregister it
    print "Registering COM server..."
    import win32com.server.register
    win32com.server.register.UseCommandLine(OphirPyCOM)