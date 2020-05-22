{

                            var tbldata=this.get('responseData');
                            tbldata=JSON.parse(tbldata);
                            console.log(tbldata);

                            var obj={"data":tbldata,"columns":[{"data":"id"},{"data":"name"},{"data":"start_date"},{"data":"end_date"},{"data":"created_on"},{"data":"description"},{"data":"user"}]};


                            $("#tableData").DataTable(obj);
                        },