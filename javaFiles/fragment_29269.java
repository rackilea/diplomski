class Employee {
  // employee properties
}

@Injectable()
class EmployeeService {
  constructor(private http: Http) {}

  getEmployee(empId: number): Observable<Employee> {
    return this.http.get(`${empBaseUrl}/${empId}`)
      .map(res => res.json() as Employee)
  }
}